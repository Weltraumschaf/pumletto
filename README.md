# Pumletto

Experimental CLI tool to generate [PlantUML](http://plantuml.com/) files from Java sources.

This tool is based on the [UMLDoclet](https://github.com/talsma-ict/umldoclet). It is just a wrapper so you can invoke it easily without setting up a Maven or Ant build script or even figure out how to call the `javadoc` tool the right way.

## Build from Source

```
$> cd pumletto
$> mvn clean intsall
```

After that you have a binary `pumletto` in directory `target`.

## Examples

Generate the PlantUML files from a source directory with a root package named `de`:
 
```
$> pumletto -s ~/some-project/src/main/java --subpackages de
```

Generate the PlantUML files from a source directory with a root package named `de` and SVG images:

```
$> pumletto -s ~/some-project/src/main/java --subpackages de -f SVG
```