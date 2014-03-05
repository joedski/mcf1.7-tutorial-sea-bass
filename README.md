# Tutorial Mod from Sea Bass' Tutorial
## Modding Minecraft 1.7 with Forge

[Here is Sea Bass' tutorial on how to add a new block, a new item, and a new entity with AI.](http://www.minecraftforum.net/topic/2389683-172-forge-add-new-block-item-entity-ai-creative-tab-language-localization-block-textures-side-textures/)

I'm stepping through this tutorial as someone who is new to Java, but is experienced with JavaScript and ActionScript3 (the latter of which is kinda structured like Java.)  This will be reflected in the comments which detail my meditations on various minutiae and sometimes things unrelated altogether.

Some things may be different from how other modders do them.  That's because I'm new to modding as of writing this!  Some things may be slightly different from how Java people do it.  That's because I like JavaScript which is a wholely different language.

There are some minor differences between Sea Bass' tutorial code and the code in this repo.  A few are detailed here:
- The package name is a full name rather than just a single-deep name because you should be naming your packages with full names.  Usually something like "com.&lt;your name&gt;.&lt;mod(or group) name&gt;".  I added an extra "tutorial" after "com" because I'm going through a bunch of tutorials and want to keep them grouped logically together.
- MODID is different because I'm going through different tutorials and I'm practicing naming things uniquely.  You should do it, too!  It's fun!  (not really, but it *is* necessary.)
- There are/will be two separate blocks, one for using the same texture all over, and one for using different textures on various sides.
- The block's name is attached to the block's class in a public static final String creatively named NAME, just like with the MODID and NAME for the mod, because I hate magic values and you should too!  (You shouldn't change the name after you write the class the first time, though.  That's even worse!)  I use this so I don't have to chop down the string returned by getUnlocalizedName().  No idea if that's good or bad, though.  Proceed with caution.

More may be added to this list as time goes on.

## Navigating the Project

There are/will be tags you can use to quickly and easily jump to various points in the tutorial history, since looking at the differences/diffs between files is easier than trying to find them yourself.  That's why we have computers, anyway.

As of writing, tags are:
* 1-block-texture - A new mod with a single block inserted into a new Creative tab.  The block has a texture, too.  This matches steps 1-3 of the tutorial.
* *2-block-sided-texture* - A block with a different texture for the top than from the rest of the sides.

More will be added as progress through the tutorial is made.

## Setup

You might have noticed there are no Forge sources in here.  Congratulations, Shinji!  Er wait...

I set my workspace up according to [this here thang by MrrGingerNinja](http://www.minecraftforum.net/topic/2413773-172-modding-with-forge-1-jdk-eclipse-forge-and-gradle/).  Incidentally, if you're new to Eclipse, that's a good way to introduce yourself to it.

## Stop Reading Here

Yes, I cuddle all the braces.  I like my braces.  They are cute and cuddly.  I might change that in future projects to match the Forge style more closely maybe.  Maybe not.

There's a probably badly done Norwegian Bokmål localization because av læring dårlig norsk.
