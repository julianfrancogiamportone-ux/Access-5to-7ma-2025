/************************************************************
 *  SISTEMA DE MONEDAS LOCAL
 ************************************************************/

// Inicializar monedas si no existen
if (!localStorage.getItem("monedas")) {
  localStorage.setItem("monedas", "0");
}

// Mostrar monedas en el header si existe
function actualizarMonedasUI() {
  const monedas = parseInt(localStorage.getItem("monedas")) || 0;
  const ui = document.querySelector("#monedas");
  if (ui) ui.textContent = `${monedas} M`;
}

actualizarMonedasUI();

/************************************************************
*  CARRITO — Agregar producto
************************************************************/
function agregarAlCarrito(producto) {
  let carrito = JSON.parse(localStorage.getItem("carrito")) || [];

  const index = carrito.findIndex(p => p.nombre === producto.nombre);
  if (index !== -1) {
      carrito[index].cantidad += 1;
  } else {
      carrito.push(producto);
  }

  localStorage.setItem("carrito", JSON.stringify(carrito));
}

/************************************************************
*  CARGAR JUEGOS DESDE BACKEND (API)
************************************************************/
window.addEventListener("DOMContentLoaded", () => {
  cargarJuegos();
  cargarTrailer();
});

// Cargar tarjetas desde la API y rellenarlas
function cargarJuegos() {
  fetch("/api/juegos")
      .then(r => r.json())
      .then(juegos => {
          const contenedor = document.querySelector(".juegos");
          const plantilla = document.querySelector(".card-juego.plantilla");

          if (!contenedor || !plantilla) return;

          contenedor.innerHTML = ""; // limpiar juegos anteriores

          juegos.forEach(juego => {
              let card = plantilla.cloneNode(true);
              card.classList.remove("plantilla");
              card.style.display = "block";

              // Rellenar datos del juego
              card.querySelector(".imagen-juego").src = juego.imagen;
              card.querySelector(".imagen-juego").alt = juego.nombre;
			  

              card.querySelector(".NJ").textContent = juego.nombre;
              card.querySelector(".precio").textContent = `${juego.precio} USD`;
			  card.querySelector(".plataforma").textContent = juego.descripcion;

              // Botones
              card.querySelector(".boton-carrito").dataset.nombre = juego.nombre;
              card.querySelector(".comprar-monedas").dataset.nombre = juego.nombre;

              contenedor.appendChild(card);
          });

          marcarJuegosComprados();
      })
      .catch(err => console.error("Error cargando juegos:", err));
}

/************************************************************
*  MANEJO DE BOTONES 
************************************************************/
document.addEventListener("click", e => {

  /******** Añadir al carrito (USD) ********/
  if (e.target.classList.contains("boton-carrito")) {

      const card = e.target.closest(".card-juego");
      const nombre = card.querySelector(".NJ").textContent.trim();
      const precio = parseFloat(card.querySelector(".precio").textContent.replace("USD", ""));
      const imagen = card.querySelector(".imagen-juego").src;

      agregarAlCarrito({ nombre, precio, imagen, cantidad: 1 });

      alert(nombre + " añadido al carrito.");
  }

  /******** Comprar con Monedas ********/
  if (e.target.classList.contains("comprar-monedas")) {
      const card = e.target.closest(".card-juego");
      const nombre = card.querySelector(".NJ").textContent.trim();
      const precioMonedas = parseInt(e.target.dataset.precio);

      comprarConMonedas(nombre, precioMonedas);
  }
});

/************************************************************
*  TRAILER DESDE API
************************************************************/
function cargarTrailer() {
  fetch("/api/trailers/1")
      .then(r => r.json())
      .then(data => {
          const iframe = document.getElementById("trailer-video");
          if (iframe) iframe.src = data.urlVideo;
      })
      .catch(err => console.error("Trailer no cargado:", err));
}

/************************************************************
*  COMPRA CON MONEDAS
************************************************************/
function comprarConMonedas(nombreJuego, precioMonedas) {
  let monedas = parseInt(localStorage.getItem("monedas")) || 0;

  if (monedas < precioMonedas) {
      alert("No tienes suficientes monedas.");
      return false;
  }

  monedas -= precioMonedas;
  localStorage.setItem("monedas", monedas.toString());

  actualizarMonedasUI();
  marcarJuegosComprados();

  alert("¡Has comprado " + nombreJuego + " con monedas!");
  return true;
}

/************************************************************
*  SUMAR MONEDAS POR COMPRA USD
************************************************************/
function sumarMonedasPorCompra() {
  let monedas = parseInt(localStorage.getItem("monedas")) || 0;
  monedas += 50;
  localStorage.setItem("monedas", monedas.toString());
  actualizarMonedasUI();
}

window.sumarMonedasPorCompra = sumarMonedasPorCompra;
window.comprarConMonedas = comprarConMonedas;
