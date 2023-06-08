var selectedRow = null;

document.getElementById('metaForm').addEventListener('submit', function(e) {
    e.preventDefault();

    var meta = document.getElementById('meta').value;
    var descricao = document.getElementById('descricao').value;
    var valor = document.getElementById('valor').value;
    var data = document.getElementById('data').value;

    if (selectedRow) {
        // Edit existing row
        selectedRow.cells[0].innerHTML = meta;
        selectedRow.cells[1].innerHTML = descricao;
        selectedRow.cells[2].innerHTML = valor;
        selectedRow.cells[3].innerHTML = data;
        selectedRow = null;
    } else {
        // Add new row
        var table = document.getElementById('metaTable');
        var row = table.insertRow(-1);
        var metaCell = row.insertCell(0);
        var descricaoCell = row.insertCell(1);
        var valorCell = row.insertCell(2);
        var dataCell = row.insertCell(3);
        var actionsCell = row.insertCell(4);

        metaCell.innerHTML = meta;
        descricaoCell.innerHTML = descricao;
        valorCell.innerHTML = valor;
        dataCell.innerHTML = data;
        actionsCell.innerHTML = '<button class="btn btn-success" onclick="editRow(this)">Editar</button>' +
                                '<button class="btn btn-success" onclick="deleteRow(this)">Excluir</button>';
    }

    document.getElementById('metaForm').reset();
});

function editRow(button) {
    selectedRow = button.parentNode.parentNode;
    document.getElementById('meta').value = selectedRow.cells[0].innerHTML;
    document.getElementById('descricao').value = selectedRow.cells[1].innerHTML;
    document.getElementById('valor').value = selectedRow.cells[2].innerHTML;
    document.getElementById('data').value = selectedRow.cells[3].innerHTML;
}

function deleteRow(button) {
    var row = button.parentNode.parentNode;
    row.parentNode.removeChild(row);
}