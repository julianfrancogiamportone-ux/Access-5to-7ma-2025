document.addEventListener("DOMContentLoaded", () => {
    const form = document.getElementById("formPago");
    const mensajeExito = document.getElementById("mensaje-exito");
    const btnVolver = document.getElementById("volver");
    const btnPagar = document.getElementById("btnPagar");

    form.addEventListener("submit", (e) => {
        e.preventDefault();

        btnPagar.disabled = true;
        btnPagar.textContent = "Procesando...";

        setTimeout(() => {

            // Vaciar carrito
            localStorage.removeItem("carrito");

            // SUMAR 50 MONEDAS
            if (typeof sumarMonedasPorCompra === "function") {
                sumarMonedasPorCompra();
            }

            form.classList.add("hidden");
            btnPagar.classList.add("hidden");

            mensajeExito.classList.remove("hidden");
            btnVolver.classList.remove("hidden");

        }, 900);
    });

    btnVolver.addEventListener("click", () => {
        history.back();
    });
});
