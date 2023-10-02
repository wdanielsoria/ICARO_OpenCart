Feature: Registro de usuario en un sitio web

  Scenario: Crear una cuenta de usuario exitosamente
    Given El usuario está en la página de inicio
    When El usuario hace clic en "My Account"
    And El usuario hace clic en "Register"
    And El usuario completa el formulario de registro con los siguientes datos:
      | Nombre       | Apellido | Correo              | Teléfono    | Contraseña | Confirmar Contraseña |
      | Daniel         | Soria      | wds@example.com    | 1234567890  | password123   | password123             |
    And El usuario acepta la política de privacidad
    And El usuario hace clic en "Continuar"
    Then Se muestra un mensaje de éxito que contiene "Congratulations! Your new account has been successfully created!"
