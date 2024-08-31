DESCRIPTION = "Testing HMM statically"
PR = "r1"

do_build() {
    # Set the paths to the files
    log_dir="$(dirname "$(realpath "$0")")"
    local test_c_path="$log_dir/../../../../../project-files/test.c"
    local libhmm_path="$log_dir/../../../../../project-files/libhmm.a"
    local run_script_path="$log_dir/../../../../../project-files/run_executable.sh"
    local output_executable="$log_dir/../../../../../project-files/test.exe"

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

