(function (d) {
    function e() {
        var a = c.getBoundingClientRect().width;
        750 < a && (a = 750);
        a = a / 750 * 100;
        c.style.fontSize = a + "px";
        var b = parseFloat(window.getComputedStyle(document.documentElement)["font-size"]);
        b !== a && 0 < b && 1 < Math.abs(b - a) && (c.style.fontSize = a * a / b + "px")
    }

    var c = d.document.documentElement, f;
    d.addEventListener("resize", function () {
        clearTimeout(f);
        f = setTimeout(e, 100)
    }, !1);
    e()
})(window);