// =============== | Bubble Sort | =============== //

let arr = [2, 4, 9, 6, 3, 7, 5, 8, 1]
function bubbleSort(arr) {
    let temp = 0;
    for(let i = 0; i < arr.length; i++){
        for(let j = 0; j < arr.length - 1; j++){
            if(arr[j] > arr[j + 1]){
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
    return arr;
}

console.log(bubbleSort(arr));