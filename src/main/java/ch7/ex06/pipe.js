function pipe() {
    if(arguments.length == 0){
        print("Need argument")
        return
    }
    var args = Array.prototype.slice.call(arguments)
    result = $EXEC(args[0])
    for each ( var arg in args) {
        result = $EXEC(arg, result)
    }
    print(result)
}


pipe('ls -la')
pipe('find .', 'grep -v class', 'sort')
pipe()
