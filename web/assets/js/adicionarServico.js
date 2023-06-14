var serviceTable = document.getElementById("serviceTable");
var serviceForm = document.getElementById("serviceForm");
var editRowIndex = -1;

serviceForm.addEventListener("submit", function (event) {
  event.preventDefault(); // Evita o envio do formulário

  // Obter os valores dos campos
  var serviceName = document.getElementById("serviceName").value;
  var serviceValue = document.getElementById("serviceValue").value;
  var paymentDate = document.getElementById("paymentDate").value;

  if (editRowIndex === -1) {
    // Adicionar um novo serviço
    var newRow = serviceTable.insertRow(-1);
    var nameCell = newRow.insertCell(0);
    var valueCell = newRow.insertCell(1);
    var dateCell = newRow.insertCell(2);
    var actionsCell = newRow.insertCell(3);

    nameCell.textContent = serviceName;
    valueCell.textContent = serviceValue;
    dateCell.textContent = paymentDate;
    actionsCell.innerHTML =
      '<button onclick="editRow(this)" class="btn btn-success"><span class="material-icons">edit</span></button> <button onclick="deleteRow(this)" class="btn btn-success"><span class="material-icons">delete</span></button>';
  } else {
    // Editar um serviço existente
    var row = serviceTable.rows[editRowIndex];
    row.cells[0].textContent = serviceName;
    row.cells[1].textContent = serviceValue;
    row.cells[2].textContent = paymentDate;
    row.cells[3].innerHTML =
      '<button onclick="editRow(this)" class="btn btn-success"><span class="material-icons">edit</span></button> <button onclick="deleteRow(this)" class="btn btn-success"><span class="material-icons">delete</span></button>';

    editRowIndex = -1; // Resetar o índice de edição
  }

  // Limpar os campos do formulário
  serviceForm.reset();
});

function editRow(button) {
  var row = button.parentNode.parentNode;
  var cells = row.cells;

  document.getElementById("serviceName").value = cells[0].textContent;
  document.getElementById("serviceValue").value = cells[1].textContent;
  document.getElementById("paymentDate").value = cells[2].textContent;

  editRowIndex = row.rowIndex;
}

function deleteRow(button) {
  var row = button.parentNode.parentNode;
  serviceTable.deleteRow(row.rowIndex);
}
