#How to use the Async Debugger
This is a simple little project that creates five actors that represent animals on a farm.  When an animal receives a message to speak, they log what they are told to say, which could be one of five possible statements.  A dog might say "Moo", a sheep might say "Meow".  The point is that any of the animal actors could receive a message to say any one of the possible utterances.  We can use Async Debugger to look at where the message comes from.

##Getting Started
Clone this project to your local machine

Download [Scala IDE v4.2 or later](http://scala-ide.org/download/sdk.html)

Start Eclipse

Switch to the Debug perspective
* Go to Window menu
* Select "Open Perspective" menu item and select "Debug" below that

Add the Async Stack tab to your Eclipse panes
* Go to Window menu
* Select "Show View" menu item and the nested "Other" menu item below that
* Select "Scala", and "Async Stack" below that

Open the CrazyFarm.scala source file

Right-click on the body of the source file, and select "Debug As..."  If the "Select Launcher" dialog appears, choose "Scala Application (new debugger)" launcher.

Open the Debug Configurations dialog box.  Under the "Scala Debugger" tab, check the "Enable Async Stack Trace functionality" checkbox, and ensure that the chosen launcher displayed at the bottom of the tab says "Using Scala Application (new debugger) Launcher".  If it says otherwise, click the "Select other..." link and choose it.  Then, press the Debug button.  From this point forward, you can right-click on the source file you want to run, select "Debug As" and choose "Scala Application".

Use the debugger as you always would.  Set breakpoints and view Variables in the Debug perspective.  When you hit a breakpoint, click on the breakpoint inside of the thread in the "Debug" pane.  This will display the current variable values in the Variable pane.  Click on the message in the pane (likely $X1 if your name for it doesn't show up), and go to the Async Stack pane.  You should see only certain stack frame calls in black, which represent the point when an actor sent a message.  If you click on one of those message sends, you can see the state of the variables in that actor at the time the message was sent.
