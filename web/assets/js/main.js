// Capturando os elementos do menu
var openMenuButton = document.querySelector('.open-menu-button');
var closeMenuButton = document.querySelector('.close-menu-button');
var fullscreenMenu = document.querySelector('.fullscreen-menu');
var body = document.querySelector('body');

// Função para abrir o menu
function openMenu() {
  fullscreenMenu.style.display = 'block';
  body.classList.add('no-scroll');
}

// Função para fechar o menu
function closeMenu() {
  fullscreenMenu.style.display = 'none';
  body.classList.remove('no-scroll');
}

// Adicionando eventos de clique aos botões do menu
openMenuButton.addEventListener('click', openMenu);
closeMenuButton.addEventListener('click', closeMenu);
