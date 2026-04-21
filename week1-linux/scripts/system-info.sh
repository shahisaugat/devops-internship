#!/bin/bash
echo "Date & Time: $(date)"
echo ""

echo "System Information"
echo "Hostname: $(hostname)"
echo "kernel: $(uname  -r)"
echo "Architecture: $(uname -m)"
echo ""

echo "User Information"
echo "Current User: $(whoami)"
echo "Home Dir: $HOME"
echo "Shell: $SHELL"
echo ""

echo "CPU Information"
echo "CPU Model: $(grep 'model name' /proc/cpuinfo | head -1)"
echo "CPI Cores: $(nproc)"

echo "Memory"
free -h | grep -E "Mem|Swap"
echo ""

echo "Disk"
df -h / | tail -1
echo ""

echo "Network"
ip addr show | grep "inet"
echo ""

echo "TOP 5 Memory Processes"
ps aux --sort=-%mem | head -6
echo ""
