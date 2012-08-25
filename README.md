KompicsIDE
==========

Eclipse plugin for Kompics development support

Projects
--------
There are 4 projects that make up the plugin:
KompicsIDE <-- The actual plugin containing UI elements, actions, model scanner and validator
KompicsMetaModel <-- an EMF eCore model for Kompics that is used by the IDE
KompicsIDE Feature <-- a feature project which bundles the two above
KompicsIDE Update <-- an update site projects for the KompicsIDE feature


Installation
------------
For Kompics development: Install plugin and dependencies from cloud1.sics.se update site into an existing Eclipse Juno installation

For KompicsIDE plugin development: clone this repository and import the four projects into Eclipse Juno installation


Usage
-----
1. To enable Kompics nature right-click a Java project and hit "Add/Remove Kompics Nature" in the dropdown menu
2. To open the Kompics Model View go to Window -> Show View -> Other... and search for "Kompics"
3. The view will automatically update when project is built. To force immediate update do a clean followed by a rebuild
