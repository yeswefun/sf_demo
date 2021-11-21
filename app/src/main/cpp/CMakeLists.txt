
cmake_minimum_required(VERSION 3.10.2)

project("sf00")

set(APK_ABI arm64-v8a)
set(FFMPEG_DIR ${PROJECT_SOURCE_DIR}/ffmpeg)
include_directories(${FFMPEG_DIR}/include)
link_directories(${FFMPEG_DIR}/${APK_ABI})

set(FFMPEG_LIBS
        avcodec
        avdevice
        avfilter
        avformat
        avutil
        postproc
        swresample
        swscale)

foreach(libname ${FFMPEG_LIBS})
    add_library(${libname} SHARED IMPORTED)
    set_target_properties(
            ${libname}
            PROPERTIES IMPORTED_LOCATION
            ${FFMPEG_DIR}/${APK_ABI}/lib${libname}.so
    )
endforeach()


add_library(
# Sets the name of the library.
native-lib

# Sets the library as a shared library.
SHARED

# Provides a relative path to your source file(s).
native-lib.cpp )

find_library(
# Sets the name of the path variable.
log-lib

# Specifies the name of the NDK library that
# you want CMake to locate.
log )

target_link_libraries(
# Specifies the target library.
native-lib

${FFMPEG_LIBS}

android

# Links the target library to the log library
# included in the NDK.
${log-lib} )

