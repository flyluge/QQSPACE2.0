var data = {
	"top_nav": {
		"img": "img",
		"name": "123"
	},
};
$(document).ready(function() {
});



var name = new Vue({
	el: ".app",
	data: {
		message: data.top_nav.name
	}
})
