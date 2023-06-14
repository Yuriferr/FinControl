var selectedRow = null;

document.getElementById('metaForm').addEventListener('submit', function(e) {
    e.preventDefault();

    var meta = document.getElementById('meta').value;
    var descricao = document.getElementById('descricao').value;
    var valor = document.getElementById('valor').value;
    var data = document.getElementById('data').value;

    if (selectedRow) {
        selectedRow.cells[0].innerHTML = meta;
        selectedRow.cells[1].innerHTML = descricao;
        selectedRow.cells[2].innerHTML = valor;
        selectedRow.cells[3].innerHTML = data;
        selectedRow = null;
    } else {
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
        actionsCell.innerHTML = '<button class="edit-button btn btn-success" onclick="editRow(this)"><span class="material-icons">edit</span></button>' +
                                '<button class="delete-button btn btn-success" onclick="deleteRow(this)"><span class="material-icons">delete</span></button>' +
                                '<button class="notify-button btn btn-success" onclick="setNotification(this)"><span class="material-icons">notifications</span></button>';
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

function setNotification(button) {
    var row = button.parentNode.parentNode;
    var meta = row.cells[0].innerHTML;
    var data = row.cells[3].innerHTML;

    if (Notification.permission === 'granted') {
        createNotification(meta, data);
    } else if (Notification.permission !== 'denied') {
        Notification.requestPermission().then(function(permission) {
            if (permission === 'granted') {
                createNotification(meta, data);
            }
        });
    }
}

function createNotification(meta, data) {
    var currentDate = new Date();
    var notificationDate = new Date(data);

    if (notificationDate > currentDate) {
        var timeDifference = notificationDate.getTime() - currentDate.getTime();
        var daysDifference = Math.ceil(timeDifference / (1000 * 3600 * 24));
        
        var notification = new Notification('Meta Tracker', {
            body: 'A meta "' + meta + '" está perto da data de conclusão! Faltam ' + daysDifference + ' dia(s).',
            icon: 'notification-icon.png'
        });

        notification.onclick = function() {
            window.focus();
            notification.close();
        };
    }
}