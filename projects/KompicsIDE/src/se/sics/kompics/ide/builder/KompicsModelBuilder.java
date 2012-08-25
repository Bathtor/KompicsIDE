/*******************************************************************************
 * Copyright (c) 2012 Lars Kroll.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     Lars Kroll - initial API and implementation
 ******************************************************************************/
package se.sics.kompics.ide.builder;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;

import se.sics.kompics.ide.Activator;
import se.sics.kompics.ide.Model;

public class KompicsModelBuilder extends IncrementalProjectBuilder {

	private List<ASTNode> deferredUnits = new LinkedList<ASTNode>();
	
	private IProject curProject = null;

	public void defer(ASTNode astn) {
		deferredUnits.add(astn);
	}

	private void retryDeferred() {
		ASTNode[] dv = deferredUnits.toArray(new ASTNode[deferredUnits.size()]);
		deferredUnits.clear();
		for (ASTNode astn : dv) {
			ModelVisitor mv = new ModelVisitor(astn, this);
			astn.accept(mv);
		}
	}

	// class SampleDeltaVisitor implements IResourceDeltaVisitor {
	// /*
	// * (non-Javadoc)
	// *
	// * @see
	// * org.eclipse.core.resources.IResourceDeltaVisitor#visit(org.eclipse
	// * .core.resources.IResourceDelta)
	// */
	// public boolean visit(IResourceDelta delta) throws CoreException {
	// IResource resource = delta.getResource();
	// switch (delta.getKind()) {
	// case IResourceDelta.ADDED:
	// // handle added resource
	// checkModel(resource);
	// break;
	// case IResourceDelta.REMOVED:
	// // handle removed resource
	// break;
	// case IResourceDelta.CHANGED:
	// // handle changed resource
	// checkModel(resource);
	// break;
	// }
	// // return true to continue visiting children.
	// return true;
	// }
	// }

	// class SampleResourceVisitor implements IResourceVisitor {
	// public boolean visit(IResource resource) {
	// checkModel(resource);
	// // return true to continue visiting children.
	// return true;
	// }
	// }

	public static final String BUILDER_ID = "KompicsIDE.kompicsModelBuilder";

	private static final String MARKER_TYPE = "KompicsIDE.modelProblem";
	
	private final Map<String, IMarker> markers = new HashMap<String, IMarker>();

	void addMarker(String id, IResource file, String message, int lineNumber, int severity) {
		if (file == null) {
			file = curProject;
		}
		if (file == null) {
			return; // No idea where to add the marker
		}
		if (markers.get(id) != null) return; // marker has already been added
		try {
			IMarker marker = file.createMarker(MARKER_TYPE);
			marker.setAttribute(IMarker.MESSAGE, message);
			marker.setAttribute(IMarker.SEVERITY, severity);
			if (lineNumber == -1) {
				lineNumber = 1;
			}
			marker.setAttribute(IMarker.LINE_NUMBER, lineNumber);
		} catch (CoreException e) {
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.internal.events.InternalBuilder#build(int,
	 * java.util.Map, org.eclipse.core.runtime.IProgressMonitor)
	 */
	protected IProject[] build(int kind, Map args, IProgressMonitor monitor) throws CoreException {
		// if (kind == FULL_BUILD) {
		// fullBuild(monitor);
		// } else {
		// IResourceDelta delta = getDelta(getProject());
		// if (delta == null) {
		// fullBuild(monitor);
		// } else {
		// incrementalBuild(delta, monitor);
		// }
		// }
		fullBuild(monitor);
		return null;
	}

	void checkModel(IResource resource) {
		IProject project = resource.getProject();
		curProject = project;
		deleteMarkers(project);
		markers.clear();
		String header = "***********************\n";
		header += "****** NEW BUILD ******\n";
		header += "***********************\n";
		Activator.log("\n" + header);
		try {
			IPackageFragment[] packages = JavaCore.create(project).getPackageFragments();
			// parse(JavaCore.create(project));
			for (IPackageFragment mypackage : packages) {
				if (mypackage.getKind() == IPackageFragmentRoot.K_SOURCE) {
					createAST(mypackage);
				}
			}
			int defNum = deferredUnits.size() + 1; // just to get it started^^
			while (deferredUnits.size() < defNum) {
				defNum = deferredUnits.size();
				retryDeferred();
			}
			if (deferredUnits.size() != 0) {
				String error = "Sorry it appears that we have hit a dead end";
				error += " while retrying deferred compilation units.";
				error += "\n This is most likely due to a circular dependency in the model.";
				Activator.log(error);
			}
			Activator.log("\n *** Validating Model ***");
			ModelValidator mv = new ModelValidator(this);
			mv.validate();
		} catch (JavaModelException e) {
			Activator.log(IStatus.ERROR, e.getMessage());
		}

	}

	private void createAST(IPackageFragment mypackage) throws JavaModelException {
		for (ICompilationUnit unit : mypackage.getCompilationUnits()) {
			// Now create the AST for the ICompilationUnits
			CompilationUnit parse = parse(unit);
			ModelVisitor visitor = new ModelVisitor(parse, this);
			parse.accept(visitor);
		}
	}

	/**
	 * * Reads a ICompilationUnit and creates the AST DOM for manipulating the *
	 * Java source file * * @param unit * @return
	 */

	private static CompilationUnit parse(ICompilationUnit unit) {
		ASTParser parser = ASTParser.newParser(AST.JLS4);
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		parser.setSource(unit);
		parser.setResolveBindings(true);
		return (CompilationUnit) parser.createAST(null); // parse
	}

	private void deleteMarkers(IResource file) {
		try {
			file.deleteMarkers(MARKER_TYPE, false, IResource.DEPTH_INFINITE);
		} catch (CoreException ce) {
		}
	}

	protected void fullBuild(final IProgressMonitor monitor) throws CoreException {

		Model.clearAll();
		checkModel(getProject());

	}

	// protected void incrementalBuild(IResourceDelta delta, IProgressMonitor
	// monitor)
	// throws CoreException {
	// // the visitor does the work.
	// delta.accept(new SampleDeltaVisitor());
	// }
}
