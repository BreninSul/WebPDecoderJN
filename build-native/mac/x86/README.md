# Compile for Mac 

## Step 2: Compile dynamic library

For compiling the folder structure should look like this (this could be the
prefix `<dir>` specified above):

    libwebp_animdecoder.c
    makefile
    include\webp\decode.h
    include\webp\demux.h
    include\webp\types.h
    lib\libwebp.lib
    lib\libwebpdemux.lib
    
Run `arch -x86_64 make` to create the library.

`liblibwebp_animdecoder.dylib is what you need`