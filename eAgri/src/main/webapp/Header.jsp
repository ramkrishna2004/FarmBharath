<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.15/dist/tailwind.min.css" rel="stylesheet">
    <title>Navigation Bar</title>
</head>
<body>

  <nav class="bg-lightgreen border-gray-200 dark:bg-gray-900">
    <div
      class="max-w-screen-xl flex flex-wrap items-center justify-between mx-auto p-4"
    >
      <a href="#" class="flex items-center">
        <img src="Images/logo.png" class="h-16 mr-3" alt="Flowbite Logo" />
        <span
          class="self-center text-2xl font-semibold whitespace-nowrap dark:text-white"
          >FarmBharath</span
        >
      </a>
      <button
        data-collapse-toggle="navbar-default"
        type="button"
        class="inline-flex items-center p-2 w-10 h-10 justify-center text-sm text-gray-500 rounded-lg md:hidden hover:bg-gray-100 focus:outline-none focus:ring-2 focus:ring-gray-200 dark:text-gray-400 dark:hover:bg-gray-700 dark:focus:ring-gray-600"
        aria-controls="navbar-default"
        aria-expanded="false"
      >
        <span class="sr-only">Open main menu</span>
        <svg
          class="w-5 h-5"
          aria-hidden="true"
          xmlns="http://www.w3.org/2000/svg"
          fill="none"
          viewBox="0 0 17 14"
        >
          <path
            stroke="currentColor"
            stroke-linecap="round"
            stroke-linejoin="round"
            stroke-width="2"
            d="M1 1h15M1 7h15M1 13h15"
          />
        </svg>
      </button>
      <div class="hidden w-full md:block md:w-auto" id="navbar-default">
        <ul
          class="font-medium flex flex-col p-4 md:p-0 mt-4 border border-gray-100 rounded-lg bg-gray-50 md:flex-row md:space-x-8 md:mt-0 md:border-0 md:bg-white dark:bg-gray-800 md:dark:bg-gray-900 dark:border-gray-700"
        >
          <li>
            <a
              href="index.jsp"
              class="block py-2 pl-3 pr-4 text-green-500 bg-blue-700 rounded md:bg-transparent md:p-0 dark:text-white md:dark:text-green-500"
              aria-current="page"
              >Home</a
            >
          </li>
          <li>
            <a
              href="#"
              class="block py-2 pl-3 pr-4 text-gray-900 rounded hover:bg-gray-100 md:hover:bg-transparent md:border-0 hover:text-green-500 md:hover:text-green-700 md:p-0 dark:text-white md:dark:text-blue-500 dark:hover:bg-gray-700 dark:hover:text-white md:dark:hover:bg-transparent"
              >About</a
            >
          </li>

          <li>
            <div class="">
              <button class="hover:text-green-700" id="menu-btn">Register</button>
              
              <div class="bg-gray-200 hidden flex-col rounded mt-1 p-2 text-sm w-32" id="dropdown">
                  <a href="FarmerRegister.jsp" class="px-2 py-1 hover:bg-green-400 rounded">Farmer</a>
                  <a href="ExporterRegister.jsp" class="px-2 py-1 hover:bg-green-400 rounded">Buyer</a>
                  
                  
                  
              </div>
          </div>
      
          <script>
              window.addEventListener('DOMContentLoaded', ()=> {
                  const menuBtn = document.querySelector('#menu-btn')
                  const dropdown = document.querySelector('#dropdown')
                  
                  menuBtn.addEventListener('click', () => {
                      /* if(dropdown.classList.contains('hidden')){
                          dropdown.classList.remove('hidden');
                          dropdown.classList.add('flex');
                      }else{
                          dropdown.classList.remove('flex')
                          dropdown.classList.add('hidden')
                      } */
      
                      dropdown.classList.toggle('hidden')
                      dropdown.classList.toggle('flex')
                  })
      
              })
          </script>
          </li>

          <li>
            <div class="">
              <button class="hover:text-green-700" id="menu-btn2">Login</button>
              
              <div class="bg-gray-200 hidden flex-col rounded mt-1 p-2 text-sm w-32" id="dropdown2">
                  <a href="FarmerLogin.jsp" class="px-2 py-1 hover:bg-green-400 rounded">Farmer</a>
                  <a href="ExporterLogin.jsp" class="px-2 py-1 hover:bg-green-400 rounded">Buyer</a>
                  <a href="AdminPannelLogin.jsp" class="px-2 py-1 hover:bg-green-400 rounded">Admin</a>
                  
              </div>
          </div>
      
          <script>
              window.addEventListener('DOMContentLoaded', ()=> {
                  const menuBtn = document.querySelector('#menu-btn2')
                  const dropdown = document.querySelector('#dropdown2')
                  
                  menuBtn.addEventListener('click', () => {
                      /* if(dropdown.classList.contains('hidden')){
                          dropdown.classList.remove('hidden');
                          dropdown.classList.add('flex');
                      }else{
                          dropdown.classList.remove('flex')
                          dropdown.classList.add('hidden')
                      } */
      
                      dropdown.classList.toggle('hidden')
                      dropdown.classList.toggle('flex')
                  })
      
              })
          </script>
          </li>
          <li>
            <a
              href="#"
              class="block py-2 pl-3 pr-4 text-gray-900 rounded hover:bg-gray-100 md:hover:bg-transparent md:border-0 hover:text-green-500 md:hover:text-green-700 md:p-0 dark:text-white md:dark:text-blue-500 dark:hover:bg-gray-700 dark:hover:text-white md:dark:hover:bg-transparent"
              >Contact</a
            >
          </li>
        </ul>
      </div>
    </div>
  </nav>

</body>
</html>