//alert(location)  // http://127.0.0.1:5500/src/update.html?id=1&nombre=Focaccia&email=1500&prioridad=15
//alert(location.search)  // devuelve de la URL desde el ? , muestra "?id=1&nombre=Focaccia&email=1500&prioridad=15"
//alert(location.search.substr(1))  // devuelve de la URL a partir del ? , muestra "id=1&nombre=Focaccia&email=1500&prioridad=15"

var args = location.search.substr(1).split('&');
//alert(args)

// args='id=1,nombre=Focaccia,email=1500,prioridad=15'
console.log(args)
    // lee los argumentos pasados a este formulario
var parts = []
for (let i = 0; i < args.length; ++i) {
    parts[i] = args[i].split('=');
    console.log(parts[i])
}
// parts=[ [id,1], [nombre,'Focaccia'], [email,'x1500],[prioridad,15]]
// parts[0] [id,1]
// parts[1] [nombre,'Focaccia']
// parts[2] [email,'xxxxx']
// parts[3] [prioridad,15]

document.getElementById("id").value = parts[0][1]
document.getElementById("titulo").value = parts[1][1]
document.getElementById("autor").value = parts[2][1]
document.getElementById("imagen").value = parts[3][1]
document.getElementById("descripcion").value = parts[4][1]
document.getElementById("stock").value = parts[5][1]
document.getElementById("precio").value = parts[6][1]
document.getElementById("destacado").value = parts[7][1]

function modificar() {
    let i = document.getElementById("id").value
    let t = document.getElementById("titulo").value
    let a = document.getElementById("autor").value
    let im = document.getElementById("imagen").value
    let d = document.getElementById("descripcion").value
    let s = parseInt(document.getElementById("stock").value)
    let p = parseFloat(document.getElementById("precio").value)
    let des = document.getElementById("destacado").value
    let libro = {
        id: i,
        titulo: t,
        autor: a,
        imagen: im,
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
        redirect: 'follow'
    }

    fetch(url, options)
        .then(function() {
            console.log("modificado")
            alert("Registro modificado")
                // Handle response we get from the API
        })
        .catch(err => {
            //this.errored = true
            console.error(err);
            alert("Error al Modificar")
        })
}