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

### Installation

1. **Clone the Repository**

   ```bash
   git clone https://github.com/ShadiBahaa/HMM-with-bitbake.git
   cd HMM-with-bitbake
   ```
2. **Watch the Video to know how to navigate through the project**
  - kfkd
