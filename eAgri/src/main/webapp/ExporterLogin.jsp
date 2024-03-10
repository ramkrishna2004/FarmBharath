<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.15/dist/tailwind.min.css" rel="stylesheet">
    <title>Navigation Bar</title>
</head>
<style>
    @font-face {
    font-family: myFont;
    src: url(Chivo.ttf);
  }
    body{
     background-image:url('Images/backgournd.png');
     background-repeat: no-repeat;
     background-attachment: fixed;
     background-size: 100%;
     backdrop-filter: blur(5px);
     background-position-y: 100%;
           font-family: myFont;


    }
    p{
      font-family: myFont;
    }
</style>
<body>
<%@ include file="Header.jsp" %>
  <div class="container mx-auto my-20 p-14 py-10 mb-96 max-w-md bg-white rounded shadow-md">
    <form action="ExporterLogin" method="post">
        <h1 class="text-2xl mb-10 ">Company Login</h1>

        <div class="mb-7 mt-7">
            <label for="email" class="block text-gray-700">Email-id</label>
            <input
              type="email"
              id="email"
              name="email"
              class="w-full px-3 py-2 bg-gray-200 rounded focus:ring-2 focus:ring-green-300"
              placeholder="Email"
              required
            />
            </div>
            <div class="mb-7 mt-7">
                <label for="password" class="block text-gray-700">Password</label>
                <input
                  type="password"
                  id="password"
                  name="password"
                  class="w-full px-3 py-2 bg-gray-200 rounded focus:ring-2 focus:ring-green-300"
                  placeholder="Password"
                  required
                />
			</div>

      <div class="mb-7 mt-7">
        <button
          type="submit"
          class="bg-green-500 hover:bg-blue-300 text-white py-2 px-4 rounded transition-transform transform hover:scale-105 duration-300 ease-in-out"
        >
          Submit
        </button>
      </div>
    </form>
   
  </div>
  




</body>
</html>