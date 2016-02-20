var range = document.getElementById("range"),
    iframe = document.getElementById("iframe");

range.addEventListener("input", function() {
    iframe.style.opacity = range.value/100;
}, false);

iframe.style.opacity = 0;