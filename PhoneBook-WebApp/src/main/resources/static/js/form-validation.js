/**
 * 
 */
$(function() {
  $("form[name='registration']").validate({
    
    rules: {
     	contactName: "required",
      
    	contactEmail: {
        required: true,
        email: true
      },
      contactNumber: {
        required: true,
        minlength: 10
      }
    },

    messages: {
    	contactName: "Please enter name to save the contact",
    
    	contactEmail: "Please enter a valid email address",
    	contactNumber:{
    		required: "Please enter contact number",
    		minlength: "please enter atleast 10 digits contact number"
    	}
    },
    submitHandler: function(form) {
      form.submit();
    }
  });
});