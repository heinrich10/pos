package com.app.inv.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.inv.mapper.MenuItemMapper;
import com.app.inv.model.MenuItem;
import com.app.inv.model.MenuItemList;
import com.app.inv.model.MenuItemType;

@Controller
@RequestMapping("/maintenance")
public class MenuItemController {
	
	@Inject
	private MenuItemMapper menuItemMapper;
	
	@RequestMapping(value = "/mi", method = RequestMethod.GET)
	public ModelAndView viewMenuItem(Map<String, Object> myModel){
		
		MenuItemList menuItemList = new MenuItemList(menuItemMapper.loadMenuItem());
		
		List<MenuItemType> arrMenuItemType = menuItemMapper.loadMenuItemType();
		
		myModel.put("tabletype", "menuItem");
		myModel.put("menuItem", menuItemList);
		myModel.put("mitype", arrMenuItemType);
		
		return new ModelAndView("maintenance", myModel);
		
	}
	
	@RequestMapping(value = "/mi/edit", method=RequestMethod.GET)
	public ModelAndView editMenuItem(
			@RequestParam("code") String[] code,
			Map<String, Object> myModel,
			MenuItemList menuItemList
			){
		menuItemList.setMenuItemList(menuItemMapper.loadMenuItem(code));
		List<MenuItemType> arrMenuItem = menuItemMapper.loadMenuItemType();
		
		myModel.put("menuItem", menuItemList);
		myModel.put("menuItemType", arrMenuItem);
		myModel.put("tabletype", "menuItemEdit");
		
		return new ModelAndView("maintenance", myModel);
		
	}
	
	@RequestMapping(value= "/mi/edit", method=RequestMethod.POST)
	public String updateMenuItem(
			@ModelAttribute("menuItemList") MenuItemList menuItemList
			){
		
		for(MenuItem mi:menuItemList.getMenuItemList()){
			menuItemMapper.updateMenuItem(mi);
		}
		
		return "redirect:/maintenance/mi";
		
	}
	
	@RequestMapping(value = "/mi/type", method=RequestMethod.GET)
	public ModelAndView viewMenuItemType(Map<String, Object> myModel){
		
		List<MenuItemType> arrMenuItemType = menuItemMapper.loadMenuItemType();
		
		myModel.put("object", arrMenuItemType);
		myModel.put("tabletype", "mitype");
		
		return new ModelAndView("maintenance", "model", myModel);
		
	}
	
	@RequestMapping(value = "/mi/type/add", method=RequestMethod.GET)
	public ModelAndView addMenuItemType(Map<String, Object> myModel){
		
		myModel.put("editType", "miType");
		myModel.put("menuItemType", new MenuItemType());
		
		return new ModelAndView("edit", myModel);
	}
	
	@RequestMapping(value = "/mi/type/add", method=RequestMethod.POST)
	public String saveMenuItemType(
			@ModelAttribute("menuItemType") MenuItemType menuItemType
			){
		
		menuItemMapper.saveMenuItemType(menuItemType);
		
		return "redirect:/maintenance/mi/type";
	}
	
	//@RequestMapping(value = "/mi/mitype/edit", method=RequestMethod.GET)
	//public ModelAndView editMenuItemType(
	//		@RequestParam("code") String code,
	//		Map<String, Object> myModel
	//		){
	//	
	//	MenuItemType menuItemType = menuItemMapper.loadMenuItemType(code);
	//	myModel.put("menuItemType", menuItemType);
	//	myModel.put("editType", "miType");
	//	return new ModelAndView("edit", myModel);
	//}
	
	//@RequestMapping(value = "/mi/mitype/edit", method=RequestMethod.POST)
	//public String updateMenuItemType(
	//		@ModelAttribute("menuItemType") MenuItemType menuItemType
	//		){
	//	menuItemMapper.updateMenuItemType(menuItemType);
	//	return "redirect:/maintenance/mi/mitype";
	//}
	
	@RequestMapping(value = "/mi/type/delete", method=RequestMethod.POST)
	public String deleteMenuItemType(
			@RequestParam("code") String[] code
			){
		
		menuItemMapper.deleteMenuItemType(code);
		
		return "redirect:/maintenance/mi/type";
	}
	
	

/*
public Recipe loadRecipe(MenuItem menuItem){
    
    Recipe recipe = null;
    
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    try {
      
        DBEntity db = DBEntity.getInstance();           
            
        con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
 
        pst = con.prepareStatement(
                "SELECT  OMR.code_menu, OMR.code_ingredient, IIC.name, quantity, OMR.unit, CU.name FROM oms_mi_recipe OMR join im_ingredient_code IIC on OMR.code_ingredient = IIC.code join core_units CU on OMR.unit = CU.code_unit where code_menu = ?");
        
        pst.setString(1, menuItem.getCode());
        
        rs = pst.executeQuery();
        
        recipe = new Recipe();
        
        while(rs.next()){
            
            recipe.addIngredient(new Ingredient(rs.getString("code_menu"), rs.getString("code_ingredient"), rs.getString("iic.name"), rs.getInt("quantity"), rs.getString("unit"), rs.getString("cu.name")));
        }
        
        
    } catch (SQLException ex) {
        Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
       
    } finally{
        
        try {
            if(rs != null){
                rs.close();
            }
            
            if(pst != null){
                pst.close();
            }
            
            if(con != null){
               con.close(); 
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(IngredientController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    return recipe;
    
}



public void saveRecipe(Recipe recipe){
    
    Connection con = null;
    PreparedStatement pst = null;
    
    try {
        
        DBEntity db = DBEntity.getInstance();
        con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
            
       // String query = "insert into oms_mi_recipe(create_date, update_date, update_user, update_program, code_menu, code_ingredient, quantity, unit) values (?, ?, ?, ?, ?, ?, ?, ?) on duplicate key update quantity = ?, update_date = ?";
        //PreparedStatement pst = con.prepareStatement(query);
            
        for(int i = 0; i < recipe.size(); i++){
            String query = "insert into oms_mi_recipe(create_date, update_date, update_user, update_program, code_menu, code_ingredient, quantity, unit) values (?, ?, ?, ?, ?, ?, ?, ?) on duplicate key update quantity = ?, update_date = ?, unit = ?";
            pst = con.prepareStatement(query);    
            pst.setDate(1, new java.sql.Date(new java.util.Date().getTime()));
            pst.setDate(2, new java.sql.Date(new java.util.Date().getTime()));
            pst.setString(3, "pgm");
            pst.setString(4, "RecipeService");
            pst.setString(5, recipe.getIngredient(i).getCodeMenu());
            pst.setString(6, recipe.getIngredient(i).getCodeIngredient());
            pst.setInt(7, recipe.getIngredient(i).getQuantity());
            pst.setString(8, recipe.getIngredient(i).getUnit());
            pst.setInt(9, recipe.getIngredient(i).getQuantity());
            pst.setDate(10, new java.sql.Date(new java.util.Date().getTime()));
            pst.setString(11, recipe.getIngredient(i).getUnit());
            pst.executeUpdate();
                
        }
                
            
    } catch (SQLException ex) {
        Logger.getLogger(RecipeService.class.getName()).log(Level.SEVERE, null, ex);
    } finally{
        
        try {
            
            if(pst != null){
                pst.close();
            }
            
            if(con != null){
               con.close(); 
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(RecipeService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
        
       
    
}

public void deleteRecipe(Recipe recipe){
    
    Connection con = null;
    PreparedStatement pst = null;
    
    try {
        
        DBEntity db = DBEntity.getInstance();
        con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
            
        String query = "delete from oms_mi_recipe where code_menu = ? and code_ingredient = ?";
        pst = con.prepareStatement(query);
            
        for(int i = 0; i < recipe.size(); i++){
                
            pst.setString(1, recipe.getIngredient(i).getCodeMenu());
            pst.setString(2, recipe.getIngredient(i).getCodeIngredient());
            pst.executeUpdate();
                
        }
                
            
    } catch (SQLException ex) {
        Logger.getLogger(RecipeService.class.getName()).log(Level.SEVERE, null, ex);
    } finally{
        
        try {
            
            if(pst != null){
                pst.close();
            }
            
            if(con != null){
               con.close(); 
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(RecipeService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
	*/
}
