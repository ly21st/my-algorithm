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
include CMakeFiles/cfg.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/cfg.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/cfg.dir/flags.make

CMakeFiles/cfg.dir/lingshengxueyuan/HuLianWangYunPan/0voice-cloud-disk/common/cfg.c.obj: CMakeFiles/cfg.dir/flags.make
CMakeFiles/cfg.dir/lingshengxueyuan/HuLianWangYunPan/0voice-cloud-disk/common/cfg.c.obj: ../lingshengxueyuan/HuLianWangYunPan/0voice-cloud-disk/common/cfg.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=E:\liyuan-github\my-algorithm\cpp\build\CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building C object CMakeFiles/cfg.dir/lingshengxueyuan/HuLianWangYunPan/0voice-cloud-disk/common/cfg.c.obj"
	"E:\Program Files\LLVM\bin\x86_64-w64-mingw32-gcc.exe" $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -o CMakeFiles\cfg.dir\lingshengxueyuan\HuLianWangYunPan\0voice-cloud-disk\common\cfg.c.obj   -c E:\liyuan-github\my-algorithm\cpp\lingshengxueyuan\HuLianWangYunPan\0voice-cloud-disk\common\cfg.c

CMakeFiles/cfg.dir/lingshengxueyuan/HuLianWangYunPan/0voice-cloud-disk/common/cfg.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/cfg.dir/lingshengxueyuan/HuLianWangYunPan/0voice-cloud-disk/common/cfg.c.i"
	"E:\Program Files\LLVM\bin\x86_64-w64-mingw32-gcc.exe" $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E E:\liyuan-github\my-algorithm\cpp\lingshengxueyuan\HuLianWangYunPan\0voice-cloud-disk\common\cfg.c > CMakeFiles\cfg.dir\lingshengxueyuan\HuLianWangYunPan\0voice-cloud-disk\common\cfg.c.i

CMakeFiles/cfg.dir/lingshengxueyuan/HuLianWangYunPan/0voice-cloud-disk/common/cfg.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/cfg.dir/lingshengxueyuan/HuLianWangYunPan/0voice-cloud-disk/common/cfg.c.s"
	"E:\Program Files\LLVM\bin\x86_64-w64-mingw32-gcc.exe" $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S E:\liyuan-github\my-algorithm\cpp\lingshengxueyuan\HuLianWangYunPan\0voice-cloud-disk\common\cfg.c -o CMakeFiles\cfg.dir\lingshengxueyuan\HuLianWangYunPan\0voice-cloud-disk\common\cfg.c.s

# Object files for target cfg
cfg_OBJECTS = \
"CMakeFiles/cfg.dir/lingshengxueyuan/HuLianWangYunPan/0voice-cloud-disk/common/cfg.c.obj"

# External object files for target cfg
cfg_EXTERNAL_OBJECTS =

cfg.exe: CMakeFiles/cfg.dir/lingshengxueyuan/HuLianWangYunPan/0voice-cloud-disk/common/cfg.c.obj
cfg.exe: CMakeFiles/cfg.dir/build.make
cfg.exe: CMakeFiles/cfg.dir/linklibs.rsp
cfg.exe: CMakeFiles/cfg.dir/objects1.rsp
cfg.exe: CMakeFiles/cfg.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=E:\liyuan-github\my-algorithm\cpp\build\CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking C executable cfg.exe"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles\cfg.dir\link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/cfg.dir/build: cfg.exe

.PHONY : CMakeFiles/cfg.dir/build

CMakeFiles/cfg.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles\cfg.dir\cmake_clean.cmake
.PHONY : CMakeFiles/cfg.dir/clean

CMakeFiles/cfg.dir/depend:
	$(CMAKE_COMMAND) -E cmake_depends "MinGW Makefiles" E:\liyuan-github\my-algorithm\cpp E:\liyuan-github\my-algorithm\cpp E:\liyuan-github\my-algorithm\cpp\build E:\liyuan-github\my-algorithm\cpp\build E:\liyuan-github\my-algorithm\cpp\build\CMakeFiles\cfg.dir\DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/cfg.dir/depend

