<h1>Axelor BPM Editor</h1>
Axelor BPM Editor is a graphical editor to design Axelor Workflow diagrams. <br />
It uses standard bpmn2.0 notation for shapes of diagram. Basic shapes of bpmn2.0 like Transition,Task and Diagram are modified to have property that link it with particular model, condition or action.<br />
On save of digram it update corresponding workflow, including new nodes and transitions. Same digram will be shown in Instance of Workflow with active nodes.<br />

<h1>Installation</h1>
* In project root directory run :<br />
<code>ant build-all-in-one-war</code><br />
* After successful build, war created is under target/axelorbpm.war .
* Put war in your server.
