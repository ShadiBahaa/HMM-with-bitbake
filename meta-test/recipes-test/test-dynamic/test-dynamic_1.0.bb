DESCRIPTION = "Testing HMM dynamically"
PR = "r1"

do_build() {
    # Set the paths to the files
    local project_dir="${TOPDIR}/../project-files"
    local test_c_path="$project_dir/test.c"
    local lib_dir_path="$project_dir"
    local run_script_path="$project_dir/run_executable.sh"
    local output_executable="$project_dir/test.exe"

    # Compile the test.c with libhmm.a into test.exe statically
    gcc -o "$output_executable" "$test_c_path" -L"$lib_dir_path" -lhmm
    if [ $? -ne 0 ]; then
        echo "Compilation failed."
        return 1
    fi
    
    export LD_LIBRARY_PATH="$lib_dir_path"
    echo "LD_LIBRARY_PATH set to: $LD_LIBRARY_PATH"

    # Run the executable with the run_executable.sh script
    chmod +x "$run_script_path"
    "$run_script_path" "$output_executable"
    if [ $? -ne 0 ]; then
        echo "Execution of $run_script_path failed."
        return 1
    fi
}
