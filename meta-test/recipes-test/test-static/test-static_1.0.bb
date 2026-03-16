DESCRIPTION = "Testing HMM statically"
PR = "r1"

do_build() {
    # Set the paths to the files
    local project_dir="${TOPDIR}/../project-files"
    local test_c_path="$project_dir/test.c"
    local libhmm_path="$project_dir/libhmm.a"
    local run_script_path="$project_dir/run_executable.sh"
    local output_executable="$project_dir/test.exe"

    # Compile the test.c with libhmm.a into test.exe statically
    gcc "$test_c_path" "$libhmm_path" -o "$output_executable" --static
    if [ $? -ne 0 ]; then
        echo "Compilation failed."
        return 1
    fi

    # Run the executable with the run_executable.sh script
    chmod +x "$run_script_path"
    "$run_script_path" "$output_executable"
    if [ $? -ne 0 ]; then
        echo "Execution of $run_script_path failed."
        return 1
    fi
}
