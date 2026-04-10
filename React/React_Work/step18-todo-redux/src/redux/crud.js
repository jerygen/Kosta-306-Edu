import { configureStore, createSlice } from "@reduxjs/toolkit";

const todoSlice = createSlice({
  name: "todoCRUD",
  initialState: {
    mockData: [
      {
        id: 0,
        isDone: false,
        content: "React study",
        date: new Date().getTime(),
      },
      {
        id: 1,
        isDone: false,
        content: "친구만나기",
        date: new Date().getTime(),
      },
      { id: 2, isDone: false, content: "낮잠자기", date: new Date().getTime() },
    ],
    lastId: 3,
  },
  reducers: {
    onCreate(state, action) {
      const lastId = state.lastId + 1;
      const newTodo = {
        id: lastId,
        isDone: false,
        content: action.payload,
        date: new Date().getTime(),
      };
      state.mockData.unshift(newTodo);
    },
    onUpdate(state, action) {
      const index = state.mockData.findIndex(
        (todo) => todo.id === action.payload,
      );
      state.mockData[index].isDone = !state.mockData[index].isDone;
    },
    onDelete(state, action) {
      state.mockData = state.mockData.filter(
        (todo) => todo.id !== action.payload,
      );
    },
  },
});

export const { onCreate, onUpdate, onDelete } = todoSlice.actions;

export default configureStore({
  reducer: { todoCRUD: todoSlice.reducer },
});
