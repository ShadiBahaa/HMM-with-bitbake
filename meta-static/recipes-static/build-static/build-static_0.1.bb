DESCRIPTION = "Building the HMM library statically"
PR = "r1"
do_build () {
    log_dir="$(dirname "$(realpath "$0")")"
    
    local dir="$log_dir/../../../../../project-files"

    if [ ! -d "$dir" ]; then
        echo "Directory '$dir' does not exist."
        return 1
    fi


    if [ -f "$dir/Makefile" ]; then
        (cd "$dir" && make libhmm.a)
    else
        echo "Makefile not found in the directory '$dir'."
        return 1
    fi
}
