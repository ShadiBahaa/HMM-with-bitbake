DESCRIPTION = "Testing HMM dynamically"
PR = "r1"

do_build() {
    # Set the paths to the files
    log_dir="$(dirname "$(realpath "$0")")"
    local test_c_path="$log_dir/../../../../../project-files/test.c"
    local lib_dir_path="$log_dir/../../../../../project-files"
    local run_script_path="$log_dir/../../../../../project-files/run_executable.sh"
    local output_executable="$log_dir/../../../../../project-files/test.exe"

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

