Files = java.nio.file.Files
Paths = java.nio.file.Paths
StandardCharsets = java.nio.charset.StandardCharsets
Arrays = java.util.Arrays
String = java.lang.String
contents = new String(Files.readAllBytes(Paths.get('../../../resources/ch2/alice.txt')), StandardCharsets.UTF_8)
s = Arrays.stream(Java.to(contents.split(/\W/), "java.lang.String[]")).distinct()
s = s.filter(function(w) w.length() >= 12)
s = s.sorted()
s.forEachOrdered(function(w) print(w))
