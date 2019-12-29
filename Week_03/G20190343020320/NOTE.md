学习笔记

随堂练习

func recursion(level, param1, param2...) re {
    // recursion terminator
    if level > MAX_LEVEL {
        process_result
        return
    }

    // process logic in current level
    process(level, param1, param2...)

    // drill dowm
    recursion(level + 1, param1, param2...)

    // reverse the current level status if needed
}