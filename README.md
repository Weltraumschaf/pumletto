# Pumletto

Experimental CLI tool to generate [PlantUML](http://plantuml.com/) files from Java sources.

## Build from Source

```
$> cd pumletto
$> mvn clean intsall
```

After that you have a binary `pumletto` in directory `target`.

## Examples

```
$> pumletto -s ~/some-project/src/main/java --subpackages de
```