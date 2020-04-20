var i = 0;

setInterval(
    () => {
        i += 1;
        if (i == 6)
//            document.location.href = "ent.html";
       window.open
       
       
       ("http://192.168.43.36:8089/ent.html","_blank");
        	console.log(i);
    }, 2000

);