# Setup with VSCode:
Download the [JAVA extension](vscode:extension/vscjava.vscode-java-pack)

If link is dead, try the offical [VSCode JAVA tutorial](https://code.visualstudio.com/docs/languages/java)


# Configuration
Take a picture of the monitor with the game running and open in any image editor.

Using the coordinates in the iamge editor, set the click location for the various bit buttons.

For example, the click location for Bit 1 is x=1580 and y (defined earlier)

```java
if (bits[0]) click(1580,y); // Bit 1
```

# Usage
Simply type the number in the window and press enter. The corresponding bits will automatically be clicked ant entered, with the cursor being returned to the window.

I would recommend doing this with two monitors, with this tool on the second monitor. Otherwise once the game is clicked, the window will be hidden underneath it.

You CAN do this with one monitor, but you will have to make adjustments with the game in windowed mode so both the game and the tool can fit on one monitor unobstructed.