# CMAKE generated file: DO NOT EDIT!
# Generated by "MinGW Makefiles" Generator, CMake Version 3.15

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Remove some rules from gmake that .SUFFIXES does not remove.
SUFFIXES =

.SUFFIXES: .hpux_make_needs_suffix_list


# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

SHELL = cmd.exe

# The CMake executable.
CMAKE_COMMAND = "D:\Program Files\JetBrains\CLion-2019.2.5-jbr8.win\bin\cmake\win\bin\cmake.exe"

# The command to remove a file.
RM = "D:\Program Files\JetBrains\CLion-2019.2.5-jbr8.win\bin\cmake\win\bin\cmake.exe" -E remove -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = E:\liyuan-github\my-algorithm\cpp

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = E:\liyuan-github\my-algorithm\cpp\cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/MyCircularDeque.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/MyCircularDeque.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/MyCircularDeque.dir/flags.make

CMakeFiles/MyCircularDeque.dir/MyCircularDeque.cpp.obj: CMakeFiles/MyCircularDeque.dir/flags.make
CMakeFiles/MyCircularDeque.dir/MyCircularDeque.cpp.obj: ../MyCircularDeque.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=E:\liyuan-github\my-algorithm\cpp\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/MyCircularDeque.dir/MyCircularDeque.cpp.obj"
	E:\MinGW64\x86_64-8.1.0-release-posix-sjlj-rt_v6-rev0\mingw64\bin\g++.exe  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles\MyCircularDeque.dir\MyCircularDeque.cpp.obj -c E:\liyuan-github\my-algorithm\cpp\MyCircularDeque.cpp

CMakeFiles/MyCircularDeque.dir/MyCircularDeque.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/MyCircularDeque.dir/MyCircularDeque.cpp.i"
	E:\MinGW64\x86_64-8.1.0-release-posix-sjlj-rt_v6-rev0\mingw64\bin\g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E E:\liyuan-github\my-algorithm\cpp\MyCircularDeque.cpp > CMakeFiles\MyCircularDeque.dir\MyCircularDeque.cpp.i

CMakeFiles/MyCircularDeque.dir/MyCircularDeque.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/MyCircularDeque.dir/MyCircularDeque.cpp.s"
	E:\MinGW64\x86_64-8.1.0-release-posix-sjlj-rt_v6-rev0\mingw64\bin\g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S E:\liyuan-github\my-algorithm\cpp\MyCircularDeque.cpp -o CMakeFiles\MyCircularDeque.dir\MyCircularDeque.cpp.s

# Object files for target MyCircularDeque
MyCircularDeque_OBJECTS = \
"CMakeFiles/MyCircularDeque.dir/MyCircularDeque.cpp.obj"

# External object files for target MyCircularDeque
MyCircularDeque_EXTERNAL_OBJECTS =

MyCircularDeque.exe: CMakeFiles/MyCircularDeque.dir/MyCircularDeque.cpp.obj
MyCircularDeque.exe: CMakeFiles/MyCircularDeque.dir/build.make
MyCircularDeque.exe: CMakeFiles/MyCircularDeque.dir/linklibs.rsp
MyCircularDeque.exe: CMakeFiles/MyCircularDeque.dir/objects1.rsp
MyCircularDeque.exe: CMakeFiles/MyCircularDeque.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=E:\liyuan-github\my-algorithm\cpp\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX executable MyCircularDeque.exe"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles\MyCircularDeque.dir\link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/MyCircularDeque.dir/build: MyCircularDeque.exe

.PHONY : CMakeFiles/MyCircularDeque.dir/build

CMakeFiles/MyCircularDeque.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles\MyCircularDeque.dir\cmake_clean.cmake
.PHONY : CMakeFiles/MyCircularDeque.dir/clean

CMakeFiles/MyCircularDeque.dir/depend:
	$(CMAKE_COMMAND) -E cmake_depends "MinGW Makefiles" E:\liyuan-github\my-algorithm\cpp E:\liyuan-github\my-algorithm\cpp E:\liyuan-github\my-algorithm\cpp\cmake-build-debug E:\liyuan-github\my-algorithm\cpp\cmake-build-debug E:\liyuan-github\my-algorithm\cpp\cmake-build-debug\CMakeFiles\MyCircularDeque.dir\DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/MyCircularDeque.dir/depend

