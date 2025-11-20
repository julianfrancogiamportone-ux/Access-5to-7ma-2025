// carrito.js
window.addEventListener('DOMContentLoaded', () => {
  const contenedor = document.getElementById('lista-productos');
  const totalSpan = document.getElementById('total-precio');

  let carrito = JSON.parse(localStorage.getItem('carrito')) || [];
  let total = 0;

  carrito.forEach(producto => {
      const div = document.createElement('div');
      div.className = 'producto';

      div.innerHTML = `
      <img src="${producto.imagen}" alt="${producto.nombre}">
      <div>
          <h3>${producto.nombre}</h3>
          <p>${producto.cantidad} x $${producto.precio.toFixed(2)} USD</p>
          <button class="eliminar" data-nombre="${producto.nombre}">Eliminar</button>
      </div>
      `;

      contenedor.appendChild(div);
      total += producto.precio * producto.cantidad;
  });

  totalSpan.textContent = `$${total.toFixed(2)} USD`;

  document.querySelectorAll('.eliminar').forEach(boton => {
      boton.addEventListener('click', () => {
          const nombre = boton.getAttribute('data-nombre');
          eliminarDelCarrito(nombre);
      });
  });
});

function eliminarDelCarrito(nombre) {
  let carrito = JSON.parse(localStorage.getItem('carrito')) || [];
  carrito = carrito.filter(producto => producto.nombre !== nombre);
  localStorage.setItem('carrito', JSON.stringify(carrito));
  location.reload();
}

  
  