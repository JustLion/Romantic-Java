// 请编写函数将data数组中所有对象按照value从小到大排列 要求：不能使用相关集合或工具
Array.prototype.mysort = function (callback) {
	var middle = function (arr, low, high) {
		var temp = arr[low];
		while (low < high) {
			while (low < high && callback(arr[high], temp) >= 0) high--;
			arr[low] = arr[high];
			while (low < high && callback(arr[low], temp) < 0) low++;
			arr[high] = arr[low];
		}
		arr[low] = temp;
		return low;
	};
	var quickSort = function (arr, low, high) {
		if (low < high) {
			var m = middle(arr, low, high);
			quickSort(arr, low, m - 1);
			quickSort(arr, m + 1, high);
		}
	};
	if (this.length > 0) {
		quickSort(this, 0, this.length - 1);
	}
};

window.onload = function () {
	var data = [
		{name: "uc", value: 5},
		{name: "ali", value: 3},
		{name: "amap", value: 2}
	];
	data.mysort(function (a, b) {
		return a.value - b.value;
	})
};