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
CMAKE_COMMAND = "C:\Program Files (x86)\Microsoft Visual Studio\2019\BuildTools\Common7\IDE\CommonExtensions\Microsoft\CMake\CMake\bin\cmake.exe"

# The command to remove a file.
RM = "C:\Program Files (x86)\Microsoft Visual Studio\2019\BuildTools\Common7\IDE\CommonExtensions\Microsoft\CMake\CMake\bin\cmake.exe" -E remove -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = E:\liyuan-github\my-algorithm\cpp

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = E:\liyuan-github\my-algorithm\cpp\build

# Include any dependencies generated for this target.
include CMakeFiles/merge.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/merge.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/merge.dir/flags.make

CMakeFiles/merge.dir/merge.cpp.obj: CMakeFiles/merge.dir/flags.make
CMakeFiles/merge.dir/merge.cpp.obj: ../merge.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=E:\liyuan-github\my-algorithm\cpp\build\CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/merge.dir/merge.cpp.obj"
	"E:\Program Files\LLVM\bin\x86_64-w64-mingw32-g++.exe"  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles\merge.dir\merge.cpp.obj -c E:\liyuan-github\my-algorithm\cpp\merge.cpp

CMakeFiles/merge.dir/merge.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/merge.dir/merge.cpp.i"
	"E:\Program Files\LLVM\bin\x86_64-w64-mingw32-g++.exe" $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E E:\liyuan-github\my-algorithm\cpp\merge.cpp > CMakeFiles\merge.dir\merge.cpp.i

CMakeFiles/merge.dir/merge.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/merge.dir/merge.cpp.s"
	"E:\Program Files\LLVM\bin\x86_64-w64-mingw32-g++.exe" $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S E:\liyuan-github\my-algorithm\cpp\merge.cpp -o CMakeFiles\merge.dir\merge.cpp.s

# Object files for target merge
merge_OBJECTS = \
"CMakeFiles/merge.dir/merge.cpp.obj"

# External object files for target merge
merge_EXTERNAL_OBJECTS =

merge.exe: CMakeFiles/merge.dir/merge.cpp.obj
merge.exe: CMakeFiles/merge.dir/build.make
merge.exe: CMakeFiles/merge.dir/linklibs.rsp
merge.exe: CMakeFiles/merge.dir/objects1.rsp
merge.exe: CMakeFiles/merge.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=E:\liyuan-github\my-algorithm\cpp\build\CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX executable merge.exe"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles\merge.dir\link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/merge.dir/build: merge.exe

.PHONY : CMakeFiles/merge.dir/build

CMakeFiles/merge.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles\merge.dir\cmake_clean.cmake
.PHONY : CMakeFiles/merge.dir/clean

CMakeFiles/merge.dir/depend:
	$(CMAKE_COMMAND) -E cmake_depends "MinGW Makefiles" E:\liyuan-github\my-algorithm\cpp E:\liyuan-github\my-algorithm\cpp E:\liyuan-github\my-algorithm\cpp\build E:\liyuan-github\my-algorithm\cpp\build E:\liyuan-github\my-algorithm\cpp\build\CMakeFiles\merge.dir\DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/merge.dir/depend

