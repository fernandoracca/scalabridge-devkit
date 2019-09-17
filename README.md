How to work with Doodle
==========================

Familiarize yourself with SBT, the Scala Build Tool

```
$ sbt
```

Useful commands in SBT:

  * compile: Compiles your code for syntactic and type correctness
  * run: Executes your programs
  * console: Provides and interactive REPL (Read Evaluate Print Loop) where you can interactively type commands

From the console, you'll have all imports ready (including many you don't often need)

To run a demo, consider the following:

```scala
scala> (Image.circle(100).fillColor(Color.red)).draw()
```

You should see a window popup. Try changing the color or the size. Remember to close the window(s) since they can block each other.


