# HMM with Bitbake

## Overview

This repository shows my heap memory manager in a bitbake project. Bitbake meta layers and recipes for creating the manager as static library, dynamic library and testing it in both situations.

## Project Structure

- `build/`: Shows the working directory, you can see the log files of every recipe in it.
- `meta-dynamic/`: Contains dynamic library building configurations and recipe.
- `meta-static/`: Contains static library building configurations and recipe.
- `meta-test/`: Contains testing configurations for both builds and their recipes.
- `project-files/`: Contains the library C code and testing scripts.

## Getting Started

To get started with this project, follow the steps below:

### Prerequisites

- Bitbake installation: use this guide: https://a4z.gitlab.io/docs/BitBake/guide.html
- Set necessary env and remain in the same terminal for project usage:
   ```bash
   export PATH=/path/to/bbtutor/bitbake/bin:$PATH
   export PYTHONPATH=/path/to/bbtutor/bitbake/lib:$PYTHONPATH
   ```

### Installation and Usage

1. **Clone the Repository**

   ```bash
   git clone https://github.com/ShadiBahaa/HMM-with-bitbake.git
   cd HMM-with-bitbake
   ```
2. **Building static library**

   ```bash
   cd build
   bitbake build-static
   ```

3. **Testing static library (should build the static library first)**

   ```bash
   cd build
   bitbake test-static
   ```
4. **Building dynamic library**

   ```bash
   cd build
   bitbake build-dynamic
   ```
5. **Testing dynamic library (should build the dynamic library first)**

   ```bash
   cd build
   bitbake test-dynamic
   ```
6. **If you want to check the logs of recipes and the executions results of them**

   ```bash
   cd build/tmp/work
   choose the folder of the recipe you are interested in
   go to log.do_build files
   ```
### For more clarification, check this video: 
[Watch the video](https://drive.google.com/file/d/1n-0yevjcWYoMFvjHHE5UBEU-OCdFA__X/view?usp=sharing)
