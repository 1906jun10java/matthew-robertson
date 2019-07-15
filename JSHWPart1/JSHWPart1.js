fibonacci = function(n) {
    var a = 0;
    var b = 1;
    var f = 1;
    for(var i = 2; i <= n; i++){
        f = a + b;
        a = b;
        b = f;
    }
    return f;
}

sortsToo = function(array) {
    var count = array.length - 1,
        swap,
        j,
        i;

    for (j = 0; j < count; j++) {

        for (i = 0; i < count; i++) {

            if (array[i] > array[i + 1]) {
                swap = array[i + 1];
                array[i + 1] = array[i];
                array[i] = swap;
            }
        }
    }
    return array;
}
console.log(sortsToo([2,4,5,1,3,1]));


factorial = function(n) {
    if (n === 0 || n === 1)
      return 1;
    for (var i = n - 1; i >= 1; i--) {
      n = n * i;
    }
    return n;
  }