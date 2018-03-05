window.addEventListener("load", inicia);

function inicia() {
    document.getElementById("btn").addEventListener("click", delete, false);

}

function delete ()
{
    xml.open('DELETE', '../api/personas/' + "Alejandro Gómez", true);
    xml.onreadystatechange = function () {
        if (xml.readyState == 4 && (xml.status == 200 || xml.status == 204)) {
            alert("eliminao");
        }
    }
    xml.send();
}