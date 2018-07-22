window.onload = function() {
    newtp();

};

function newtp() {
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            var myObj = JSON.parse(this.responseText);

            for (var i = 0; i < myObj.products.length; i++) {

                var ok = document.createElement('div');
                ok.className = "card";
                var ok1 = document.createElement('div');
                ok1.className = "card-body";
                var y = document.createElement("span");
                var x = document.createElement("LABEL");
                x.innerHTML = myObj.products[i].likes;
                x.className = "testing";
                var x1 = document.createElement("LABEL");
                x1.innerHTML = myObj.products[i].dislikes;
                x1.className = "testing";
                var dik = document.createElement("button");
                dik.className = "btn btn-primary";

                dik.innerHTML = "dislike";
                dik.value = myObj.products[i].id;
                var but = document.createElement("button");
                but.className = "btn btn-primary thumb";
                but.innerHTML = "like";

                but.value = myObj.products[i].id;

                // but.onclick = function() {
                // sayhi(this.value);
                //};
                dik.onclick = function() {
                    senddislike(this.value);
                };

                ok1.innerHTML = myObj.products[i].post;
                ok.appendChild(ok1);
                y.appendChild(x);
                // y.appendChild(document.createElement("LABEL"));
                // y.appendChild(document.createElement("p"));
                y.appendChild(but);
                y.appendChild(x1);
                y.appendChild(dik);
                ok.appendChild(y);


                document.getElementById("hey1").appendChild(ok);
                document.getElementById("hey1").appendChild(document.createElement("br"));

            }

        }
    };
    xmlhttp.open("POST", "what.php", true);
    xmlhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xmlhttp.send("data=" + "newposts");
}

function sayhi(name) {
    sendlike(name);
}

function posmet() {
    var tht = document.getElementById("comment").value;
    newpostsend("julia", tht);

}

function newpostsend(name, wht) {
    var index = 0;
    var cml = new Array();
    if (window.XMLHttpRequest) {
        cml.push(new XMLHttpRequest());
        if (localStorage.getItem('indian') == null) {
            localStorage.setItem('indian', index);
            index++;
        } else {
            localStorage.setItem('indian', index);
        }

    } else if (window.ActiveXObject) {
        cml.push(new ActiveXObject("Microsoft.CMLHTTP"));
    }
    var i = localStorage.getItem('indian');
    cml[i].onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            location.reload();
        }
    };
    cml[i].open("POST", "what.php", true);
    cml[i].setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    var x = 'data=' + 'newwod' + '&uname=' + name + '&upost=' + wht;
    cml[i].send(x);

}

function sendlike(id) {
    var index = 0;
    var cml = new Array();
    if (window.XMLHttpRequest) {
        cml.push(new XMLHttpRequest());
        if (localStorage.getItem('indian1') == null) {
            localStorage.setItem('indian1', index);
            index++;
        } else {
            localStorage.setItem('indian1', index);
        }

    } else if (window.ActiveXObject) {
        cml.push(new ActiveXObject("Microsoft.CMLHTTP"));
    }
    var i = localStorage.getItem('indian1');
    cml[i].onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            alert("like added");
            location.reload();
        }
    };
    cml[i].open("POST", "what.php", true);
    cml[i].setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    var x = 'data=' + 'like' + '&id=' + id;
    cml[i].send(x);
}

function senddislike(id) {
    var index = 0;
    var cml = new Array();
    if (window.XMLHttpRequest) {
        cml.push(new XMLHttpRequest());
        if (localStorage.getItem('indian2') == null) {
            localStorage.setItem('indian2', index);
            index++;
        } else {
            localStorage.setItem('indian2', index);
        }

    } else if (window.ActiveXObject) {
        cml.push(new ActiveXObject("Microsoft.CMLHTTP"));
    }
    var i = localStorage.getItem('indian2');
    cml[i].onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            alert("dislike added");
            location.reload();
        }
    };
    cml[i].open("POST", "what.php", true);
    cml[i].setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    var x = 'data=' + 'dislike' + '&id=' + id;
    cml[i].send(x);
}