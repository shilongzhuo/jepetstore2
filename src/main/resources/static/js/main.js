window.onload = function() {

        function show(name){
        var xmlhttp = new XMLHttpRequest();
        xmlhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
        var products = JSON.parse(this.responseText);
        var num=0,i=0;
        num=products.length;
        var show = "<table><tr><td>productID</td><td>name</td></tr>";
        for(i=0;i<num;i++){
        show += "<tr>";
        show += "<td>" + products[i]["id"] + "</td>" + "<td>" + products[i]["name"] + "</td>";
        show += "</tr>";
    }
        show += "</table>";
        $("#message").html(show);
        $("#message").height = num*30+"px";
    }
    };
        xmlhttp.open("GET", "products?Category=" + name, true);
        xmlhttp.send();
    }

        function hide(){
        $("#message").text("products information");
    }
}