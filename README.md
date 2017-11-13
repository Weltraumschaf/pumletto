# Pumletto

Experimental CLI tool to generate [PlantUML](http://plantuml.com/) files from Java sources.

This tool is based on the [UMLDoclet](https://github.com/talsma-ict/umldoclet). It is just a wrapper so you can invoke it easily without setting up a Maven or Ant build script or even figure out how to call the `javadoc` tool the right way.

## Build from Source

```
$> cd pumletto
$> mvn clean install
```

After that you have a binary `pumletto` in directory `target`.

*IMPORTANT*: To build from source you need two of my projects because Pumletto depend on them as snapshot version:

- https://github.com/Weltraumschaf/organization
- https://github.com/Weltraumschaf/commons

You have to check them out and them build first!

## Binary Distribution

You can download the latest binary distribution here: [Download Pumletto binary](https://github.com/Weltraumschaf/pumletto/blob/master/dist/pumletto).

## Examples

Generate the PlantUML files from a source directory with a root package named `de`:
 
```
$> pumletto -s ~/some-project/src/main/java --subpackages de
```

Generate the PlantUML files from a source directory with a root package named `de` and SVG images:

```
$> pumletto -s ~/some-project/src/main/java --subpackages de -f SVG
```