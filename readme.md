#How to use the Async Debugger
This is a simple little project that creates five actors that represent animals on a farm.  When an animal receives a message to speak, they log what they are told to say, which could be one of five possible statements.  A dog might say "Moo", a sheep might say "Meow".  The point is that any of the animal actors could receive a message to say any one of the possible utterances.  We can use Async Debugger to look at where the message comes from.  When we look at the actor who sent that message, we can see what they were told to say prior to sending their own message.

For additional information about more Async Debugger features, [visit this page](http://scala-ide.org/docs/current-user-doc/features/async-debugger/index.html).

##Getting Started
Clone this project to your local machine

Download [Scala IDE v4.2 or later](http://scala-ide.org/download/sdk.html)

Start Eclipse

Switch to the Debug perspective
* Go to Window menu
* Select "Open Perspective" menu item and select "Debug" below that

Add the Async Stack tab to your Eclipse panes (if it is not already there)
* Go to Window menu
* Select "Show View" menu item and the nested "Other" menu item below that
* Select "Scala", and "Async Stack" below that

Open the CrazyFarm.scala source file

Right-click on the body of the source file, and select "Debug As..."  If the "Select Launcher" dialog appears, choose "Scala Application (new debugger)" launcher.

Open the Debug Configurations dialog box.  Under the "Scala Debugger" tab, check the "Enable Async Stack Trace functionality" checkbox, and ensure that the chosen launcher displayed at the bottom of the tab says "Using Scala Application (new debugger) Launcher".  If it says otherwise, click the "Select other..." link and choose it.  Then, press the Debug button.  From this point forward, you can right-click on the source file you want to run, select "Debug As" and choose "Scala Application".

Use the debugger as you always would.  Set a breakpoint on line 10, where the Speak message is received.  When you hit the breakpoint, click on the breakpoint inside of the thread in the "Debug" pane.  This will display the current variable values in the Variable pane.  Click on the message in the pane (likely "x1" if your name for it doesn't show up), and go to the Async Stack pane.  You should see only certain stack frame calls in black, which represent the point when an actor sent a message.  If you click on one of those message sends, you can see the state of the variables in that actor at the time the message was sent.

The key with Async Debugger is that you have to put a breakpoint where the actor would receive a message.  You can then look back in the Async Stack pane to see the trace of where the message came from, and where that actor received its message as well, along with the state of that actor at the time it sent the message.

Note that for the first message send into the RandomSpeakingAnimal, the Async Stack will show that the message was sent from a non-actor context (the main() method), but still allows you to see the logic flow.