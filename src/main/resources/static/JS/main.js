/************************************************************
 *  SISTEMA DE MONEDAS LOCAL (OPCIÓN B)
 ************************************************************/

// Inicializar monedas si no existen
if (!localStorage.getItem("monedas")) {
  localStorage.setItem("monedas", "0");
}

// Mostrar monedas en todas las páginas
function actualizarMonedasUI() {
  const monedas = parseInt(localStorage.getItem("monedas")) || 0;
  const ui = document.querySelector("#monedas");
  if (ui) ui.textContent = `${monedas} M`;
}

actualizarMonedasUI();

/************************************************************
*  MARCAR JUEGOS COMPRADOS
************************************************************/
function marcarJuegosComprados() {
  const juegosComprados = JSON.parse(localStorage.getItem("juegosComprados")) || [];

  document.querySelectorAll(".card-juego").forEach(card => {
      const nombre = card.querySelector(".NJ")?.textContent.trim();

      if (juegosComprados.includes(nombre)) {
          const boton = card.querySelector(".boton-carrito");
          boton.textContent = "YA COMPRADO";
          boton.disabled = true;
          boton.style.background = "#555";
      }
  });
}

marcarJuegosComprados();

/************************************************************
*  CARRITO — Comprar un juego con USD
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
*  CARGAR LISTA DE JUEGOS DINÁMICAMENTE (API)
************************************************************/

window.addEventListener("DOMContentLoaded", () => {

  /******** Añadir al carrito ********/
  document.querySelectorAll(".boton-carrito").forEach(boton => {
      boton.addEventListener("click", () => {

          const card = boton.closest(".card-juego");
          const nombre = card.querySelector(".NJ").textContent.trim();
          const precioTexto = card.querySelector(".precio").textContent.trim();
          const imagen = card.querySelector(".imagen-juego").getAttribute("src");

          const precio = parseFloat(precioTexto.replace("USD", "").trim());

          const producto = { nombre, precio, imagen, cantidad: 1 };

          agregarAlCarrito(producto);

          alert(`${producto.nombre} fue añadido al carrito.`);
      });
  });

  /******** Cargar trailer desde API ********/
  fetch("/api/trailers/1")
      .then(r => r.json())
      .then(data => {
          const iframe = document.getElementById("trailer-video");
          if (iframe) iframe.src = data.urlVideo;
      })
      .catch(err => console.error("Trailer no cargado:", err));

});

/************************************************************
*  SISTEMA DE COMPRA CON MONEDAS
************************************************************/

// Intentar comprar con monedas
function comprarConMonedas(nombreJuego, precioMonedas) {
  let monedas = parseInt(localStorage.getItem("monedas")) || 0;

  if (monedas < precioMonedas) {
      alert(`No tienes suficientes monedas. Necesitas ${precioMonedas}.`);
      return false;
  }

  // restar monedas
  monedas -= precioMonedas;
  localStorage.setItem("monedas", monedas.toString());

  // marcar juego como comprado
  let comprados = JSON.parse(localStorage.getItem("juegosComprados")) || [];
  if (!comprados.includes(nombreJuego)) {
      comprados.push(nombreJuego);
      localStorage.setItem("juegosComprados", JSON.stringify(comprados));
  }

  actualizarMonedasUI();
  marcarJuegosComprados();

  alert(`¡Has comprado ${nombreJuego} con monedas!`);
  return true;
}

/************************************************************
*  SUMAR MONEDAS AL PAGAR CON USD
************************************************************/

// Se llama en pago.js luego del pago
function sumarMonedasPorCompra() {
  let monedas = parseInt(localStorage.getItem("monedas")) || 0;
  monedas += 50; // 50 monedas por compra
  localStorage.setItem("monedas", monedas.toString());
  actualizarMonedasUI();
}

// Lo hacemos visible a otros JS
window.sumarMonedasPorCompra = sumarMonedasPorCompra;
window.comprarConMonedas = comprarConMonedas;
