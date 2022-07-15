function guardar() {

    let t = document.getElementById("titulo").value
    let a = document.getElementById("autor").value
    let i = document.getElementById("imagen").value
    let d = document.getElementById("descripcion").value
    let s = parseInt(document.getElementById("stock").value)
    let p = parseFloat(document.getElementById("precio").value)
    let des = document.getElementById("destacado").value

    let libro = {
        titulo: t,
        autor: a,
        imagen: i,
        descripcion: d,
        stock: s,
        precio: p,
        destacado: des
    }

    let url = "http://localhost:8080/libros"
    var options = {
        body: JSON.stringify(libro),
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },

    }
    fetch(url, options)
        .then(function() {
            console.log("creado")
            alert("Grabado")

            // Handle response we get from the API
        })
        .catch(err => {
            //this.errored = true
            alert("Error al grabar")
            console.error(err);
        })
        /* 
            console.log(libro);

            alert("hola") */
}